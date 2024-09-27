public class GeradorZebra {

//    public static String gerarEtiquetaZPL(Produto produto) {
//        String templateZPL = "^XA\n" +
//                "^CF0,60\n" +
//                "^FO50,50^FD" + produto.getNome() + "^FS\n" +
//                "^CFA,50\n" +
//                "^FO50,200^FD Pacote 1und:^FS\n" +
//                "^FO480,200^FD R$ " + String.format("%.0f", produto.getPreco_Unitario()) + "^FS\n" +
//                "^FO50,280^FD Caixa 6und:^FS\n" +
//                "^FO480,280^FD R$ " + String.format("%.0f", produto.getPreco_Caixa()) + "^FS\n" +
//                "^BY5,2,270\n" +
//                "^FO100,450^BC^FD" + produto.getCodigoBarras() + "^FS\n" +
//                "^XZ";
//        return templateZPL;
//    }
    public  String gerarEtiquetaZPL(Produto produto) {
        String nomeProduto = produto.getNomeFormatado();
        String precoUnitarioProduto = produto.getPrecoUnitarioFormatado();
        String precoCaixaProduto = produto.getPrecoCaixaFormatado();

        return "^XA\n" + // Início do código ZPL
                "^FO50,50\n" + // Posição do texto
                "^A0N,50,50\n" + // Fonte e tamanho
                "^FDProduto: " + nomeProduto + "^FS\n" + // Nome do produto
                "^FO50,100\n" + // Posição do preço
                "^A0N,50,50\n" + // Fonte e tamanho
                "^FDPreco_Unitario: " + precoUnitarioProduto + "^FS\n" + // Preço do produto
                "^FO50,150\n" + // Posição do preço
                "^A0N,50,50\n" + // Fonte e tamanho
                "^FDPreco_Caixa: " + precoCaixaProduto + "^FS\n" + // Preço do produto
                "^BY5,2,270\n" +
                "^FO100,450^BC^FD" + produto.getCodigoBarras() + "^FS\n" +
                "^XZ"; // Fim do código ZPL
    }

}
