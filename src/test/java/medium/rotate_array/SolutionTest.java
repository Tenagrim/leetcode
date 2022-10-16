package medium.rotate_array;

import org.junit.Test;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void rotate() {
        int [] arr = new int[]{1,2,3};
        solution.rotate(arr, 1);
        assertArrayEquals(new int[]{3,1,2}, arr );
    }
}