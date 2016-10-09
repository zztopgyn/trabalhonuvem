package lab.album;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
	
	public static final int QTDE_MAX_VINYL_ESTOQUE = 1000;					//QUANTIDADE MAXIMO PERMITIDA DE VINYS EM ESTOQUE
	public static final int QTDE_GRANDE_ALBUNS_ESTOQUE = 500000;			//QUANTIDADE MAXIMA PERMITIDA ACERVO
	public static final int QTDE_MESES_LANCAMENTO = 2;						//QUANTIDADE MESES CONSIDERADA LANÇAMENTOS
	public static final String MSG_ERRO_QTDE_MAX_VINYS_ESTOQUE = "A quantidade máxima permitida de vinys em estoque foi excedida!";
	
	/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = format.parse(datetime);
	SimpleDateFormat df = new SimpleDateFormat("yyyy");
	year = df.format(date);*/
	
	@Autowired
	private AlbumRepository albumRepository;
	
	private void validarAlbum (Album album) {
		if (album.getTipo().equals(Album.VINYL) && album.getQuantidade() > QTDE_MAX_VINYL_ESTOQUE) {
			throw new RuntimeException (MSG_ERRO_QTDE_MAX_VINYS_ESTOQUE);
		}
	}
	
	public Album registrarAlbum(Album album) {
		validarAlbum(album);
		album.setData(new Date());
		return albumRepository.save(album);
	}
	
	public Iterable<Album> obterAlbunsLancamentos() {
		Calendar agora = Calendar.getInstance();
		agora.add(Calendar.DATE, - QTDE_MESES_LANCAMENTO);
		return albumRepository.findByDataGreaterThan(agora.getTime());
	}
	
	public Iterable<Album> obterAlbunsEstoqueGrande() {
		return albumRepository.findByQuantidadeGreaterThan(QTDE_GRANDE_ALBUNS_ESTOQUE);
	}
	
	public Album obterAlbum (Integer codigo){
		return albumRepository.findOneByCodigo(codigo);
	}
	
	public Iterable<Album> obterTodos(){
		return albumRepository.findAll();
	}
}
