package uk.ac.strath.contextualtriggers.data;

import com.google.android.libraries.places.api.model.PlaceLikelihood;

import java.util.List;

public class PlacesData extends AbstractData {
    public List<PlaceLikelihood> places;

    public PlacesData(List<PlaceLikelihood> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof PlacesData){
            return ((PlacesData) o).places.equals(this.places) && super.equals(o);
        }
        return false;
    }
}
