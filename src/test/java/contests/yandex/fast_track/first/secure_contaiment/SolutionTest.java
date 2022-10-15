package contests.yandex.fast_track.first.secure_contaiment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void process() {
        assertTrue( Solution.process(4, new ArrayList<>(List.of(1L,2l,6l,1l))));
    }
    @Test
    public void process1_2() {
        assertFalse( Solution.process(4, new ArrayList<>(List.of(1l,2l,3l,4l))));
    }
    @Test
    public void process2() {
        assertTrue( Solution.process(8, new ArrayList<>(List.of(1L,1l,1l, 1L,2l,2l,6l,4l))));
    }
    @Test
    public void process3() {
        assertFalse( Solution.process(8, new ArrayList<>(List.of(1l,1l,2l,1l,2l,2l,6l,4l))));
    }
    @Test
    public void process4() {
        assertFalse( Solution.process(8, new ArrayList<>(List.of(1l,1l,2l,1l,2l,2l,6l,4l))));
    }
}