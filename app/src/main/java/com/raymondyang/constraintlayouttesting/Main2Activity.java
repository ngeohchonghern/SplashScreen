package com.raymondyang.constraintlayouttesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SimpleDraweeView simpleDraweeView = findViewById(R.id.simple_drawee_main);
        Uri uri = Uri.parse("https://i.ibb.co/G0ZzCC6/Mountains-Lake-Canada-Men-Scenery-Canadian-Rocky-559181-720x1280.jpg");
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);
//        RecyclerView recyclerView = findViewById(R.id.recyclerview_tes);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new NoteRecyclerAdapter(this));
//        recycl.layoutManager = LinearLayoutManager(this)
//        recyclerview.adapter = NoteRecyclerAdapter(this)

    }
}
