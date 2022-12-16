package com.example.car;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bg = Bitmap.createBitmap(720,1280,Bitmap.Config.ARGB_8888);
        ImageView i = findViewById(R.id.image);
        i.setBackgroundDrawable(new BitmapDrawable(bg));

        Canvas cg = new Canvas(bg);

        Paint p1 = new Paint();
        p1.setColor(Color.RED);
        Paint p2 = new Paint();
        p2.setColor(Color.BLACK);

        Paint p3 = new Paint();
        p3.setColor(Color.GRAY);

        cg.drawRect(200,300,550,450,p2);

        Path path = new Path();

        Point a = new Point(200,300);
        Point b = new Point(150,450);
        Point c = new Point(200,450);

        path.setFillType(Path.FillType.EVEN_ODD);

        path.lineTo(a.x,a.y);
        path.lineTo(b.x,b.y);
        path.lineTo(c.x,c.y);
        path.lineTo(a.x,a.y);

        path.close();
        cg.drawPath(path, p2);

        Path path2 = new Path();

        Point x = new Point(550,300);
        Point y = new Point(550,450);
        Point z = new Point(600,450);

        path2.lineTo(x.x,x.y);
        path2.lineTo(y.x,y.y);
        path2.lineTo(z.x,z.y);
        path2.lineTo(x.x,x.y);

        path2.close();

        cg.drawPath(path2,p2);

        cg.drawRect(50,450,700,600,p2);

        cg.drawRect(220,310,360,440,p3);
        cg.drawRect(380,310,530,440,p3);

        cg.drawCircle(150,600,50,p3);
        cg.drawCircle(580,600,50,p3);

    }
}