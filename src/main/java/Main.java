
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        var budweiser =Produto.builder()
//                .nome("Budweiser 300ml")
//                .preco_Unitario(8.0)
//                .preco_Caixa(48.0)
//                .codigoBarras("123456789")
//                .build();
//        String etiquetaZPL = GeradorZebra.gerarEtiquetaZPL(budweiser);
//
//
//        System.out.println(etiquetaZPL);


        var produtoService = new ProdutoService();
        var geradorEtiqueta = new GeradorZebra();
        var zplToPNG = new ZPLToPNG();

        try {
            // Busca o produto por ID (ex: ID 1 para "Cerveja IPA")
            Produto produto = produtoService.buscarProdutoPorId(2);

            // Gera o ZPL com as informações do produto
            String zpl = geradorEtiqueta.gerarEtiquetaZPL(produto);

            // Envia o ZPL para a API e salva o arquivo PNG
            zplToPNG.gerarImagemPNG(zpl, "etiqueta_" + produto.getNome());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
