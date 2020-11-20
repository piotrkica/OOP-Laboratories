package agh.lab;

import java.util.Comparator;

public class Vector2dComparatorX implements Comparator {    // to można trzymać w pliku z MapBoundary, bo to klasa pomocnicza

    @Override
    public int compare(Object object1, Object object2){
        if (!(object1 instanceof Vector2d) || !(object2 instanceof Vector2d)){
            throw new ClassCastException("There are 1-2 objects in comparator that are not Vector2d type"); // Comparator<Vector2d>
        }
        Vector2d vector1 = (Vector2d) object1;
        Vector2d vector2 = (Vector2d) object2;
        if (vector1.x == vector2.x){
            if (vector1.y < vector2.y) {
                return -1;  // to nie musi być +-1 - wygodniej jest zwrócić różnicę współrzędnych
            }
            else if (vector1.y > vector2.y){
                return 1;
            }
            return 0;
        }
        if (vector1.x < vector2.x){
            return -1;
        }
        return 1;
    }
}
