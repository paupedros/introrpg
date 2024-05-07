/*
 * Aquesta classe permet fer proves de les funcionalitats de les
 * diferents classes de l'aplicació de gestió de lloguer de vehicles
 *
 * ATENCIÓ: no modifiquis aquest programa
 */
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.engine.discovery.DiscoverySelectors;

import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class ProvaBasica {
    private static final Class<?>[] TESTS = { TestGestor.class };
    private static void comprovaJUnit(Class<?> target) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
            .request()
            .selectors(DiscoverySelectors.selectClass(target))
            .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        System.out.printf("%nEl resultat d'executar les proves de %s:%n", target.getName());
        System.out.println("- Tests passen > 15: " + (summary.getTestsSucceededCount() > 15));
        System.out.println("- Tests fallen: " + summary.getTestsFailedCount());
    }
    private static void comprovaGestorLite() {
        System.out.printf("%nEl resultat d'executar mètodes de la classe " +
                          "GestorLite:%n");
        Client demo = GestorLite.creaClientDemo();
        GestorLite.mostraClient(demo);
        System.out.println(demo.informe());
    }
    public static void main(String[] args) {
        comprovaGestorLite();
        for (Class target: TESTS) { comprovaJUnit(target); }
    }
}
