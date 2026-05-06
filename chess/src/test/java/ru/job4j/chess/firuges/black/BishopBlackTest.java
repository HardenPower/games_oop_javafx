package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionIsCorrect() {
        Cell source = Cell.C8;
        Cell position = new BishopBlack(source).position();
        assertThat(position).isEqualTo(source);
    }

    @Test
    void whenCopyIsCorrect() {
        BishopBlack bbSrc = new BishopBlack(Cell.C8);
        Cell goal = Cell.B7;
        Figure bbDest = bbSrc.copy(goal);
        assertThat(bbDest.position()).isEqualTo(goal);

    }

    @Test
    void whenWayIsCorrect() {
        BishopBlack bbSrc = new BishopBlack(Cell.C1);
        Cell goal = Cell.G5;
        Cell[] position = bbSrc.way(goal);
        Cell[] result = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).containsSequence(position);
    }

    @Test
    public void whenIsDiagonalTrue() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        boolean result = bishop.isDiagonal(Cell.C1, Cell.G5);
        assertThat(result).isTrue();
    }

    @Test
    public void whenIsDiagonalFalse() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        boolean result = bishop.isDiagonal(Cell.C1, Cell.C5);
        assertThat(result).isFalse();
    }
}