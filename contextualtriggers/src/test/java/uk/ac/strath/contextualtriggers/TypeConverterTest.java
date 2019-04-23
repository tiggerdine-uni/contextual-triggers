package uk.ac.strath.contextualtriggers;

import com.google.android.gms.location.DetectedActivity;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import uk.ac.strath.contextualtriggers.data.ActivityData;
import uk.ac.strath.contextualtriggers.data.AltitudeData;
import uk.ac.strath.contextualtriggers.data.BatteryData;
import uk.ac.strath.contextualtriggers.data.CalendarData;
import uk.ac.strath.contextualtriggers.data.Data;
import uk.ac.strath.contextualtriggers.data.DataConverter;
import uk.ac.strath.contextualtriggers.data.DayData;
import uk.ac.strath.contextualtriggers.data.GoalData;
import uk.ac.strath.contextualtriggers.data.ListCalendarData;
import uk.ac.strath.contextualtriggers.data.NotificationData;
import uk.ac.strath.contextualtriggers.data.PlacesData;
import uk.ac.strath.contextualtriggers.data.StepAndGoalData;
import uk.ac.strath.contextualtriggers.data.StepData;
import uk.ac.strath.contextualtriggers.data.TimeOfDayData;
import uk.ac.strath.contextualtriggers.data.VoidData;
import uk.ac.strath.contextualtriggers.data.WeatherData;

import static junit.framework.Assert.assertEquals;

public class TypeConverterTest {
    @Test
    public void ActivityTest(){
        Data d = new ActivityData(new DetectedActivity(1, 1));
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(ActivityData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void AltitudeTest(){
        Data d = new AltitudeData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(AltitudeData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void BatteryTest(){
        Data d = new BatteryData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(BatteryData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void CalendarTest(){
        Data d = new CalendarData("test", new Date(2001, 1, 1));
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(CalendarData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void GoalTest(){
        Data d = new GoalData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(GoalData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void ListCalendarTest(){
        Data d = new ListCalendarData(new ArrayList<>());
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(ListCalendarData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void NotificationTest(){
        Data d = new NotificationData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(NotificationData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void PlacesTest(){
        Data d = new PlacesData(new ArrayList<>());
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(PlacesData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void StepAndGoalTest(){
        Data d = new StepAndGoalData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(StepAndGoalData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void StepTest(){
        Data d = new StepData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(StepData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void TimeOfDayTest(){
        Data d = new TimeOfDayData(new int[10]);
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(TimeOfDayData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void VoidTest(){
        Data d = new VoidData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(VoidData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

    @Test
    public void WeatherTest(){
        Data d = new WeatherData();
        String s = DataConverter.DataToString(d);
        Data d2 = DataConverter.StringToData(s);
        assertEquals(WeatherData.class, d2.getClass());
        assertEquals(true, d.equals(d2));
    }

}
