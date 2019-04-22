package uk.ac.strath.contextualtriggers.conditions;

import com.google.android.gms.awareness.state.Weather;

import uk.ac.strath.contextualtriggers.data.WeatherData;
import uk.ac.strath.contextualtriggers.managers.IDataManager;

/**
 * Condition satisfied if current weather matches a target value. Use constants defined in
 * WeatherService to represent weather states.
 */
public class ClearWeatherCondition extends DataCondition<WeatherData> {


    public ClearWeatherCondition(IDataManager<WeatherData> dataManager) {
        super(dataManager);
    }

    @Override
    public boolean isSatisfied() {
        for(Integer i : getData().Conditions)
        {
            if(i.equals(Weather.CONDITION_CLEAR))
            {
                return true;
            }
        }
        return false;
    }

}
