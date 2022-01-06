package aman.upd.mapapplication

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mymapsapplication.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        var currentpos = fusedLocationClient.lastLocation.addOnSuccessListener {
            setUp(it, mMap)
        }

        // Add a marker in Sydney and move the camera
    }

    private fun setUp(userLoc: Location, mMap: GoogleMap) {
        val defaultPos = LatLng(13.612320, 100.836808)

        var locations = GetFaculties()

        locations.forEach{
            val icon = BitmapDescriptorFactory.fromResource(it.logoString)
            mMap.addMarker(MarkerOptions().snippet(it.abbreviation).position(defaultPos).title(it.facultyname))
        }
//        var latlang = LatLng(userLoc.latitude, userLoc.longitude)
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlang))
    }

    private fun GetFaculties(): List<AUPlace> {
        var output = mutableListOf<AUPlace>()
        var vms = AUPlace(
            "Vincent Mary School of Science and Technology",
            "VMS",
            this.getDrawable(R.drawable.vms_logo),
            13.613239,
            100.835531
        )
        var ns = AUPlace(
            "Faculty of Nursing Science",
            "NS",
            this.getDrawable(R.drawable.ns_logo),
            13.612219,
            100.838038
        )
        var msme = AUPlace(
            "Martin de tours school of economics",
            "MSME",
            this.getDrawable(R.drawable.msme_logo),
            13.612958,
            100.836499
        )
        var msm = AUPlace(
            "School of Music",
            "MS",
            this.getDrawable(R.drawable.ms_logo),
            13.612264,
            100.837577
        )
        var law = AUPlace(
            "School of law",
            "LAW",
            this.getDrawable(R.drawable.law_logo),
            13.612227,
            100.835039
        )
        var ca = AUPlace(
            "Albert Laurence School of Communication Arts",
            "CA",
            this.getDrawable(R.drawable.ca_logo),
            13.61211764458656,
            100.83525934378646
        )
        var bs = AUPlace(
            "School of Biotechnology",
            "BIOTECH",
            this.getDrawable(R.drawable.bs_logo),
            13.612014848062914,
            100.83592614129313
        )
        var arts = AUPlace(
            "Theodore Maria School of Arts",
            "ARTS",
            this.getDrawable(R.drawable.arts_logo),
            13.612151163715925,
            100.83479258493658
        )
        var ar = AUPlace(
            "Montfort Del Rosario School of Architecture and Design",
            "Music",
            this.getDrawable(R.drawable.ar_logo),
            13.612125,
            100.835519
        )

        output.add(vms)
        output.add(ns)
        output.add(msme)
        output.add(msm)
        output.add(law)
        output.add(ca)
        output.add(bs)
        output.add(arts)
        output.add(ar)

        return output
    }
}
