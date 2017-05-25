package com.example.edoardo.gymmobile;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.content.Context;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;


/**
 * Created by Edoardo on 11/02/2017.
 */

public class ActivityAllen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    public List<Album> albumList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        /*esercizi = new ListaEsercizi() ;*/

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);





        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



        albumList=prepareAlbums();

       /* try { // Quesa parte di codice è stata eliminata in quanto sopra l'immagine appariva una striscia verde //
                // l'immagine è stata correttamente caricata dal codice xml //
            Glide.with(this).load(R.drawable.arnold).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                  play_list(view);


            }
            });
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        //appbarlayout.setExpanded

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    public List<Album> prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.cyclette4,
                R.drawable.crunch,
                R.drawable.p_piana,
                R.drawable.concentrazioni,
                R.drawable.tricipiti,
                R.drawable.crunch2,


                };

        Album a = new Album("Cyclette", 10,0,0, covers[0],60000);
        albumList.add(a);

        a = new Album("Addominali", 2,8,6, covers[1],60000);
        albumList.add(a);

        a = new Album("Panca piana", 3,12,20.5, covers[2],60000);
        albumList.add(a);

        a = new Album("Concentrazioni con manubri", 3,12,10, covers[3],60000);
        albumList.add(a);

        a = new Album("Push Down Ercolina", 3,12,12, covers[4],60000);
        albumList.add(a);

        a = new Album("Abdominal Crunch", 3,20,15, covers[5],60000);
        albumList.add(a);


        adapter.notifyDataSetChanged();

        return albumList;
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }



   /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            // FAB Action goes here
        }
    });*/



    public void play_list(View v) {
        Intent intent = new Intent(this, com.example.edoardo.gymmobile.PlayList.class);


        startActivity(intent);
    }


    public List<Album> getList() {

        return albumList;

    }

}
