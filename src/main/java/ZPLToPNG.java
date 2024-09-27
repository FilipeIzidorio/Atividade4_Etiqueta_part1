import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ZPLToPNG {
    public void gerarImagemPNG(String zpl, String nomeArquivo) throws IOException, InterruptedException {
        var uri = URI.create("http://api.labelary.com/v1/printers/8dpmm/labels/4x6/0/");

        // Criação da requisição HTTP POST com o ZPL
        var request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(zpl))
                .build();

        // Cliente HTTP para envio da requisição
        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        // Verifica se a requisição foi bem-sucedida (código 200)
        if (response.statusCode() == 200) {
            // Nome do arquivo a ser salvo (PNG)
            var file = new File(nomeArquivo + ".png");

            // Salva o corpo da resposta (arquivo PNG) no disco
            Files.write(file.toPath(), response.body());

            System.out.println("Arquivo gerado com sucesso: " + file.getAbsolutePath());
        } else {
            // Tratamento de erro
            var errorMessage = new String(response.body(), StandardCharsets.UTF_8);
            System.out.println("Erro: " + errorMessage);
        }
    }
}
