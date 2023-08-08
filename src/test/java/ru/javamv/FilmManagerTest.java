package ru.javamv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    Films item1 = new Films(1, "Бладшот", "Боевик");
    Films item2 = new Films(2, "Вперед", "Мультфильм");
    Films item3 = new Films(3, "Джентельмены", "Боевик");
    Films item4 = new Films(4, "Отель 'Белград'", "Комедия");
    Films item5 = new Films(5, "Человек-невидимка", "Ужасы");
    Films item6 = new Films(6, "Тролли. Мировой тур", "Мультфильм");
    Films item7 = new Films(7, "Номер один", "Комедия");


    @Test
    public void shouldAddMovie() {
        FilmManager fm = new FilmManager();
        fm.save(item1);

        Films[] expected = { item1 };
        Films[] actual = fm.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllMovies() {
        FilmManager fm = new FilmManager();
        fm.save(item1);
        fm.save(item2);
        fm.save(item3);
        fm.save(item4);
        fm.save(item5);
        fm.save(item6);
        fm.save(item7);

        Films[] expected = {item1, item2, item3, item4, item5, item6, item7};
        Films[] actual = fm.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifThereAreNoMovies() {
        FilmManager fm = new FilmManager();

        Films[] expected = {};
        Films[] actual = fm.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastWithBaseLimit() {
        FilmManager fm = new FilmManager();
        fm.save(item1);
        fm.save(item2);
        fm.save(item3);
        fm.save(item4);
        fm.save(item5);
        fm.save(item6);
        fm.save(item7);

        Films[] expected = {item7, item6, item5, item4, item3};
        Films[] actual = fm.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastAboveBaseLimit() {
        FilmManager fm = new FilmManager(7);
        fm.save(item1);
        fm.save(item2);
        fm.save(item3);
        fm.save(item4);
        fm.save(item5);
        fm.save(item6);
        fm.save(item7);

        Films[] expected = {item7, item6, item5, item4, item3, item2, item1};
        Films[] actual = fm.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastBelowBaseLimit() {
        FilmManager fm = new FilmManager(3);
        fm.save(item1);
        fm.save(item2);
        fm.save(item3);
        fm.save(item4);
        fm.save(item5);
        fm.save(item6);
        fm.save(item7);

        Films[] expected = {item7, item6, item5};
        Films[] actual = fm.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifMoviesBelowBaseLimit() {
        FilmManager fm = new FilmManager();
        fm.save(item1);
        fm.save(item2);
        fm.save(item3);

        Films[] expected = {item3, item2, item1};
        Films[] actual = fm.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifMoviesBelowSetLimit() {
        FilmManager fm = new FilmManager(6);
        fm.save(item1);
        fm.save(item2);
        fm.save(item3);
        fm.save(item4);

        Films[] expected = {item4, item3, item2, item1};
        Films[] actual = fm.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
