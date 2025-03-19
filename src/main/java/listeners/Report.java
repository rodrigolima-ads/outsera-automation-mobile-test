package listeners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;



@Getter
public class Report extends MobileListenerAdapter {

    static Integer passo = 1;
    private static final String RESPONSAVEL = "Equipe de Automação";
    private static final String BACKGROUND = "background-color: #000000;";
    private static final String TAG_EVIDENCIA = "<tr class='evidencia'>";
    private static final String TAG_TD = "</td>";
    private static final String TAG_TR = "</tr>";
    private static final String TAG_TABLE = "</table>";
    private static final String PATH = System.getProperty("user.dir");
    public static final String TITULO = "Relátorio de Automação de Testes - Mobile";
    private static final String BS_URL_BASE = "https://app-automate.browserstack.com/dashboard/v2/";
    private static final LocalDate DATE = LocalDate.now();
    public static final Logger QA_LOGGER = Logger.getLogger("QALogger");

    private AppiumDriver<MobileElement> driver;

    public static String timeStampEvd() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
    }

    public static String capture(WebDriver driver) {
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + scnShot;

    }

    static File rootsPath = new File(String.format("%s/evidencias/relatorio/%s", PATH, DATE));

    static String pathReport() {
        if (!rootsPath.exists()) {
            boolean wasSuccessful = rootsPath.mkdirs();
            if (!wasSuccessful) {
                QA_LOGGER.info("was not successful.");
            }

        }
        return String.format("/%s/%s.html", rootsPath, scenario);


    }

    @SneakyThrows
    public void generateReport(String titulo, String acao) {

        try {

            if (passo==1) {
                    try (PrintWriter writer = new PrintWriter(pathReport(), String.valueOf(StandardCharsets.UTF_8))) {
                        writer.println("<html>");
                        writer.println("<head> <link rel='shortcut icon' href='imagens/iconAndroid.png' />  <link rel='icon' href='imagens/iconAndroid.png' type='image/x-icon' />  <title>" + TITULO + "</title>");
                        writer.println("<meta http-equiv=\"Content-Type\"content=\"text/html;charset=UTF-8\">");
                        writer.println("<style>");
                        writer.println(".evidencia{");
                        writer.println("border-collapse:collapse;");
                        writer.println("border: 1px solid black;");
                        writer.println("}");
                        writer.println(".Passed{");
                        writer.println("color: #39ff14;");
                        writer.println(BACKGROUND);
                        writer.println("}");
                        writer.println(".Warning{");
                        writer.println("color: #FFFF00;");
                        writer.println(BACKGROUND);
                        writer.println("}");
                        writer.println(".Failed{");
                        writer.println("color:#FF0000;");
                        writer.println(BACKGROUND);
                        writer.println("}");
                        writer.println(".Error{");
                        writer.println("color:#FFA500;");
                        writer.println("}");
                        writer.println("</style>");
                        writer.println("</head>");
                        writer.println("<body>");
                        writer.println("<center><h1><font color='#003366'>Relatário de Execução do Teste:</font><center><br>");
                        writer.println("<table>");
                        writer.println("<tr>");
                        writer.println("<td>");
                        writer.println("<center><h2>" + TITULO + "<font color='#FA8072'></font></h2><center><br>");
                        writer.println(TAG_TD);
                        writer.println(TAG_TR);
                        writer.println(TAG_TABLE);
                        writer.println("</p>");
                        writer.println("<center><h5>Cenário: <font color='#00AA00'>" + scenario + "</font><center><br>"); //Nova Linha
                        // INICIO BLOCO CUSTOMIZACAO PARA AMBIENTE
                        writer.println("<table border=5 colspan=5 >");
                        writer.println(TAG_EVIDENCIA);
                        writer.println("<td class='evidencia' colspan=4 ><b><center>AMBIENTE</center></b></td></tr><tr>");
                        writer.println(TAG_EVIDENCIA);
                        writer.println("<td class='evidencia' colspan=3  > BROWSER: </td><td class='evidencia' style='width:470px' >Chorme</td></tr><tr>");
                        writer.println(TAG_EVIDENCIA);
                        writer.println("<td class='evidencia' colspan=3 > SISTEMA OPERACIONAL: </td><td class='evidencia' >" + System.getProperty("os.name") + "</td></tr><tr>");
                        writer.println(TAG_EVIDENCIA);
                        writer.println(TAG_EVIDENCIA);
                        writer.println(TAG_EVIDENCIA);
                        // FIM BLOCO CUSTOMIZACAO PARA AMBIENTE
                        writer.println("<table class='evidencia' >");
                        writer.println(TAG_EVIDENCIA);
                        writer.println("<td class='evidencia' colspan=4 ><b><center>" + titulo + "</center></b></td>");
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td class='evidencia' > PASSO: </td><td class='evidencia' >" + passo + TAG_TD);
                        writer.println("<td class='evidencia' > DATA/HORA EXECUÇÃO: </td><td class='evidencia' >" + timeStampEvd() + TAG_TD);
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td class='evidencia' > AÇÃO: </td><td class='evidencia' colspan=3 >" + acao + TAG_TD);
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td class='evidencia' > Responsável: </td><td class='evidencia' >" + RESPONSAVEL + TAG_TD);
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<tr>");
                        writer.println("<td colspan=4 class='evidencia' ><center>EVIDENCIA</center></td>");
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td colspan=4 class='evidencia' ><img src='" + capture(getDriver()) + "' style= 'max-width: 100%;'width:600px;height:400px;' /></td>");
                        writer.println(TAG_TR);
                        writer.println(TAG_TABLE);
                        writer.println("</p>");
                        writer.flush();

                    }
                }else {
                    try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pathReport(), true)))) {
                        writer.println("</p>");
                        writer.println("<meta http-equiv=\"Content-Type\"content=\"text/html;charset=UTF-8\">");
                        writer.println("<table class='evidencia' >");
                        writer.println(TAG_EVIDENCIA);
                        writer.println("<td class='evidencia' colspan=4 > <center><b class='" + titulo + "' >" + titulo + "</center></b></td>");
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td class='evidencia' > PASSO: </td><td class='evidencia' >" + passo + TAG_TD);
                        writer.println("<td class='evidencia' > DATA/HORA EXECUÇÃO: </td><td class='evidencia' >" + timeStampEvd() + TAG_TD);
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td class='evidencia' > AÇÃO: </td><td class='evidencia' colspan=3 >" + acao + TAG_TD);
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td class='evidencia' > Responsável: </td><td class='evidencia' >" + RESPONSAVEL + TAG_TD);
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td colspan=4 class='evidencia' ><center>EVIDENCIA</center></td>");
                        writer.println(TAG_TR);
                        writer.println("<tr>");
                        writer.println("<td colspan=4 class='evidencia' ><img src='" + capture(getDriver()) + "' style= 'max-width: 100%;'width:600px;height:400px;' /></td>");
                        writer.println(TAG_TR);
                        writer.println(TAG_TABLE);
                        writer.println("</p>");
                        writer.flush();

                    }
                }

                passo++;
                QA_LOGGER.log(Level.INFO, () -> "[Passo evidenciado: " + acao + " ]");
            } catch (Exception e) {
                QA_LOGGER.info(e.getMessage());
        }

    }




    public String getBSAutomatedSessionURL() {

        return BS_URL_BASE + "builds/1/sessions/" + getDriver().getSessionId().toString();
    }

    /*
     * Take a screenshot of the app screen.
     */
    public String takeScreenshot() {
        String encodedString = "";
        File screenshot = createNewDir();
        try {
            File scrFile = (this.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, screenshot);

            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            encodedString = Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            QA_LOGGER.warning(e.getMessage());
        }

        return String.format("data:image/png;base64,%s", encodedString);
    }

    private File createNewDir() {

        return new File(String.format("%s/target/extent/img/%d.png",
                System.getProperty("user.dir"),
                System.currentTimeMillis()));
    }
}