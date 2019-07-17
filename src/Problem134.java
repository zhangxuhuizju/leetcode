public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ++i)
            if (canCircuit(gas, cost, i))
                return i;
        return -1;
    }

    private boolean canCircuit(int[] gas, int[] cost, int start) {
        int index = start, temp = 0, len = gas.length;
        while (index != start + len) {
            temp = temp + gas[index % len] - cost[index % len];
            if (temp < 0) return false;
            index++;
        }
        return true;
    }
}
/*
int n = gas.length;

    int total_tank = 0;
    int curr_tank = 0;
    int starting_station = 0;
    for (int i = 0; i < n; ++i) {
      total_tank += gas[i] - cost[i];
      curr_tank += gas[i] - cost[i];
      // If one couldn't get here,
      if (curr_tank < 0) {
        // Pick up the next station as the starting one.
        starting_station = i + 1;
        // Start with an empty tank.
        curr_tank = 0;
      }
    }
    return total_tank >= 0 ? starting_station : -1;
 */
