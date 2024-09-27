import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private double preco_Unitario;
    private double preco_Caixa;
    private String codigoBarras;


    public String getNomeFormatado() {
        if (nome.length() > 22) {
            return nome.substring(0, 22);
        }
        return nome;
    }

    public String getPrecoUnitarioFormatado() {
        return String.format("R$ %.2f", preco_Unitario);
    }

    public String getPrecoCaixaFormatado() {
        return String.format("R$ %.2f", preco_Caixa);
    }
}
