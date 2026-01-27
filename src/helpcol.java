public class helpcol {
    public static boolean canmovehere(float x,float y,int[][] lvldata){
        if (!IsSolid(x, y, lvldata))
            if (!IsSolid(x + 64, y + 64, lvldata))
                if (!IsSolid(x + 64, y, lvldata))
                    if (!IsSolid(x, y + 64, lvldata))
                        return true;
        return false;
    }

    private static boolean IsSolid(float x,float y,int[][] lvldata){
        if (x < 0 || x >= lvldata[0].length*80 )
            return true;
        if (y < 0 || y >= 720)
            return true;

        float xIndex = x / 80 ;
        float yIndex = y / 80;

        int value = lvldata[(int) yIndex][(int) xIndex];

        if (value >= 2 || value < 0 || value != 1)
            return true;
        return false;
    }
}
