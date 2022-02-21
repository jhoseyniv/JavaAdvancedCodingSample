package com.designpattern.Structural.ProxyPattern.PowerAccess;

public class ProxyHabitsImpl implements  PowerHabits{

    private PowerHabitImpl powerHabitImpl;
    private String habit;

    public ProxyHabitsImpl(String habit) {
        this.habit = habit;
    }

    @Override
    public void powerHabit1() {
        if(powerHabitImpl == null){
            powerHabitImpl = new PowerHabitImpl(habit);
        }
        powerHabitImpl.powerHabit1();
    }

    @Override
    public void powerHabit2() {

    }

    @Override
    public void powerHabit3() {

    }

}
