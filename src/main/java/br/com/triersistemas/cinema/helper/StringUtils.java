package br.com.triersistemas.cinema.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;

public class StringUtils {

    private StringUtils() {
    }

    public static String getRandomName() {
        List<String> nomes = new ArrayList<>();
        nomes.add("Alexson");
        nomes.add("Ana");
        nomes.add("Murilo");
        nomes.add("Matias");
        nomes.add("Vinicius");
        nomes.add("Guilherme");
        nomes.add("João Paulo");
        nomes.add("Julio");
        nomes.add("Gabriel");
        nomes.add("Edward");
        var rd = new SplittableRandom();
        return nomes.get(rd.nextInt(0, nomes.size()));
    }

    public static String getRandomMovie() {
        List<String> lista = new ArrayList<>();
        lista.add("");
        lista.add("");
        lista.add("");
        var rd = new SplittableRandom();
        return lista.get(rd.nextInt(0, lista.size()));
    }

    public static List<String> getMovieList() {
        List<String> listaRetorno = new ArrayList<>();
        List<String> lista = new ArrayList<>();
        lista.add("");
        lista.add("");
        lista.add("");
        var rd = new SplittableRandom();

        for (int i = 0; i < rd.nextInt(2, lista.size()); i++) {
            var p = lista.get(rd.nextInt(0, lista.size()));
            listaRetorno.add(p);
            lista.remove(p);
        }
        return listaRetorno;
    }
}
