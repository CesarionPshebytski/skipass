package SkiPass.CountStrategy;

import SkiPass.TimeStrategy.TimeStrategy;

public interface CountStrategy {
    public boolean count();

    public boolean isAvailable();

    public int getAvailableCount();

    public TimeStrategy getTimeStrategy();
}

