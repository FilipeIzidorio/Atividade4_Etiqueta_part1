import java.util.List;
import java.util.Arrays;

public class ProdutoService {

    // Simulação de um banco de dados ou uma chamada de API
    private List<Produto> produtos = Arrays.asList(
            new Produto(1, "Cerveja IPA", 12.50,75.0,"1010"),
            new Produto(2, "Vinho Tinto", 45.99,275.94,"1020"),
            new Produto(3, "Whisky Escocês", 159.90,959.4,"1030")
    );

    // Método para listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtos;
    }

    // Método para buscar um produto pelo ID
    public Produto buscarProdutoPorId(int id) {
        // Itera pela lista de produtos e retorna o produto com o ID correspondente
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        // Caso o ID não seja encontrado, lança uma exceção
        throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
    }
}
