package ispoonjelly.example.com.animationdemo;

import android.animation.LayoutTransition;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llContainer;
    private LinearLayout llGreen;
    private LinearLayout llBlue;
    private boolean expanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        llContainer = (LinearLayout) findViewById(R.id.ll_container);
        llGreen = (LinearLayout) findViewById(R.id.ll_green);
        llBlue = (LinearLayout) findViewById(R.id.ll_blue);
        LinearLayout llRed = (LinearLayout) findViewById(R.id.ll_red);

        llRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBlue.setLayoutParams(expanded ? compressedParams : blueExpandedParams);
                llGreen.setLayoutParams(expanded ? compressedParams : greenExpandedParams);
                llContainer.requestLayout();

                expanded = !expanded;
            }
        });

        LayoutTransition transition = llContainer.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
    }

    private LayoutParams compressedParams = new LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0);

    private LayoutParams blueExpandedParams = new LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(150));

    private LayoutParams greenExpandedParams = new LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(170));

    private static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
