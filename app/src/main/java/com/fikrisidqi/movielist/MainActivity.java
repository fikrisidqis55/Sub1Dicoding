package com.fikrisidqi.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView movList;

    private String movName[] = new String[]{"Aquaman", "Avengers: Infinity War", "Bumblebee", "Venom", "Spider-Man: Into the Spider-Verse", "Robin Hood", "How To Train Your Dragon: The Hidden World", "Once Upon a Deadpool", "Glass", "Mortal Engines"};

    private static ArrayList<Movie> generateDummmyData() {
        ArrayList<Movie> dummyMovie = new ArrayList<>();

        Movie movie = new Movie();
        movie.setMovName("Aquaman");
        movie.setMovDesc("Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.");
        movie.setImageRes(R.drawable.poster_aquaman);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Avengers: Infinity War");
        movie.setMovDesc("As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.");
        movie.setImageRes(R.drawable.poster_avengerinfinity);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Bumblebee");
        movie.setMovDesc("On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.");
        movie.setImageRes(R.drawable.poster_bumblebee);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Venom");
        movie.setMovDesc("Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.");
        movie.setImageRes(R.drawable.poster_bumblebee);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Spider-Man: Into the Spider-Verse");
        movie.setMovDesc("Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.");
        movie.setImageRes(R.drawable.poster_spiderman);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Robin Hood");
        movie.setMovDesc("A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.");
        movie.setImageRes(R.drawable.poster_robinhood);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("How To Train Your Dragon: The Hidden World");
        movie.setMovDesc("As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.");
        movie.setImageRes(R.drawable.poster_dragon);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Once Upon a Deadpool");
        movie.setMovDesc("A kidnapped Fred Savage is forced to endure Deadpool\\'s PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that\\'s full of magic, wonder And zero F\\'s.");
        movie.setImageRes(R.drawable.poster_deadpool);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Glass");
        movie.setMovDesc("In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.");
        movie.setImageRes(R.drawable.poster_glass);
        dummyMovie.add(movie);

        movie = new Movie();
        movie.setMovName("Mortal Engines");
        movie.setMovDesc("Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.");
        movie.setImageRes(R.drawable.poster_mortalengine);
        dummyMovie.add(movie);

        return dummyMovie;
    }

    private ArrayList<Movie> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi variabel movList
        movList = findViewById(R.id.mov_list);

        //deklarasi variabel adapter sebagai Adapter untuk listPlayer
        movies = generateDummmyData();

        //deklarasi variabel adapter sebagai adapter untuk movList
        //ArrayAdapter<String> movAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, movName);
        MovieAdapter adapter = new MovieAdapter(this, movies);

        //set variabel adapter sebagai Adapter untuk listPlayer
        movList.setAdapter(adapter);

        //set listener saat salah satu item di-klik
        movList.setOnItemClickListener(movListener);
    }
    //deklarasi variabel listener untuk digunakan menangkap event saat sebuah item di-klik
    AdapterView.OnItemClickListener movListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            //kode yang akan di eksekusi saat item pada posisi :position di-klik
            Toast.makeText(MainActivity.this, "Anda memilih : " + movName[position],
                    Toast.LENGTH_LONG).show();
        }
    };

}
