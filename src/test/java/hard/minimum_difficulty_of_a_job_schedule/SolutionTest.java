package hard.minimum_difficulty_of_a_job_schedule;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private  final Solution solution = new Solution();
    @Test
    public void minDifficulty() {
        assertEquals(7, solution.minDifficulty(new int[]{6,5,4,3,2,1}, 2));
    }
}