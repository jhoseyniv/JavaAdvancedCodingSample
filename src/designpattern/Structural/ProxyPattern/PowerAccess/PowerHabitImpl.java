package designpattern.Structural.ProxyPattern.PowerAccess;

public class PowerHabitImpl implements PowerHabits {
    private String habit;

    public PowerHabitImpl(String habit) {
        this.habit = habit;
    }

    @Override
    public void powerHabit1() {
        System.out.println("habit 1 " + habit);
    }

    @Override
    public void powerHabit2() {
        System.out.println("habit 2 " + habit);

    }
    @Override
    public void powerHabit3() {
        System.out.println("habit 3 " + habit);

    }
}
