package uk.ac.strath.contextualtriggers.triggers;


import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import uk.ac.strath.contextualtriggers.Action;
import uk.ac.strath.contextualtriggers.Condition;
import uk.ac.strath.contextualtriggers.actions.NotificationAction;
import uk.ac.strath.contextualtriggers.conditions.AndCondition;
import uk.ac.strath.contextualtriggers.conditions.StepCountCondition;
import uk.ac.strath.contextualtriggers.conditions.WeatherSunnyCondition;
import uk.ac.strath.contextualtriggers.data.StepData;
import uk.ac.strath.contextualtriggers.data.WeatherData;
import uk.ac.strath.contextualtriggers.managers.IDataManager;
import uk.ac.strath.contextualtriggers.managers.StepDataManager;
import uk.ac.strath.contextualtriggers.managers.WeatherDataManager;

public class DefaultTriggers {

    //This is a POINTLESS TRIGGER DO NOT USE THIS
    //should probably throw an exception on casting rather than deal with it here
    @SuppressWarnings("unchecked")
    public static ITrigger createStepMonitorTrigger(IBinder binder) throws ClassCastException{
        IDataManager<StepData> dataManager;
            dataManager = ((StepDataManager.LocalBinder) binder).getInstance();
            Trigger.Builder builder = new Trigger.Builder();
            Condition c = new StepCountCondition(StepCountCondition.LESS_THAN, 10000, dataManager);
            Action a = new NotificationAction("Go for a walk ya lazy. It's even sunny ootside!");
            builder.setCondition(c);
            builder.setAction(a);
            return builder.build();
    }

    @SuppressWarnings("unchecked")
    public static ITrigger createWeatherTrigger(IBinder stepBinder, IBinder weatherBinder) throws ClassCastException{
        IDataManager<StepData> stepDataManager;
        Log.d("Create Weather Trigger", stepBinder.toString());
        IDataManager<WeatherData> weatherDataManager;
        WeatherData targetWeather = new WeatherData();
        targetWeather.TemperatureCelsius=1;
        stepDataManager = ((StepDataManager.LocalBinder) stepBinder).getInstance();
        weatherDataManager = ((WeatherDataManager.LocalBinder) weatherBinder).getInstance();
        Trigger.Builder builder = new Trigger.Builder();
        Condition c = new StepCountCondition(StepCountCondition.LESS_THAN, 10000, stepDataManager);
        Condition c1 = new WeatherSunnyCondition(targetWeather, weatherDataManager);
        Action a = new NotificationAction("Go for a walk ya lazy. It's even sunny ootside!");
        List<Condition> conditionList = new ArrayList<>();
        conditionList.add(c);
        conditionList.add(c1);
        Condition and = new AndCondition(conditionList);
        builder.setCondition(and);
        builder.setAction(a);
        return builder.build();

    }

    @SuppressWarnings("unchecked")
    public static ITrigger createWalkIdleTrigger(IBinder stepBinder) throws ClassCastException{
        IDataManager<StepData> stepDataManager;
        Log.d("Create Weather Trigger", stepBinder.toString());

        stepDataManager = ((StepDataManager.LocalBinder) stepBinder).getInstance();
        Trigger.Builder builder = new Trigger.Builder();
        Condition c = new StepCountCondition(StepCountCondition.LESS_THAN, 5000, stepDataManager);
        Action a = new NotificationAction("Go for a walk ya lazy. Not sure if its sunny outside?! Go Anyway! You're less than half your goal!");
        List<Condition> conditionList = new ArrayList<>();
        conditionList.add(c);
        Condition and = new AndCondition(conditionList);
        builder.setCondition(and);
        builder.setAction(a);
        return builder.build();

    }
}
