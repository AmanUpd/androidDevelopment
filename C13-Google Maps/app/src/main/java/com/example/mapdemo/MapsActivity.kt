package com.example.mapdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mapdemo.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val USER = LatLng(13.612320, 100.836808)
    private val VMS = LatLng(13.613239, 100.835531)
    private val CA = LatLng(13.612227, 100.835039)
    private val AR = LatLng(13.612125, 100.835315)
    private val LAW = LatLng(13.611869,  100.837477)
    private val MS = LatLng(13.612264,  100.837577)
    private val MSME = LatLng(13.612958, 100.836499)
    private val NS = LatLng(13.612219, 100.838038)
    private val ARTS= LatLng( 13.611520, 100.837211)

    private lateinit var markerUser: Marker
    private lateinit var markerVMS: Marker
    private lateinit var markerCA: Marker
    private lateinit var markerAR: Marker
    private lateinit var markerLAW: Marker
    private lateinit var markerMS: Marker
    private lateinit var markerMSME: Marker
    private lateinit var markerNS: Marker
    private lateinit var markerARTS: Marker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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

//        markerUser = mMap.addMarker(
//            MarkerOptions().position(USER).title("USER")
//        )
//        markerUser.tag = 0

        markerVMS = mMap.addMarker(
            MarkerOptions().position(VMS).title("Vincent Mary School of Science and Technology")
        )
        markerVMS.tag = 0

        markerCA = mMap.addMarker(
            MarkerOptions().position(CA).title("Albert Laurence School of Communication Arts")
        )
        markerCA.tag = 0

        markerAR = mMap.addMarker(
            MarkerOptions().position(AR).title("Montfort Del Rosario School of Architecture and Design")
        )
        markerAR.tag = 0

        markerLAW = mMap.addMarker(
            MarkerOptions().position(LAW).title("School of Law")
        )
        markerLAW.tag = 0

        markerMS = mMap.addMarker(
            MarkerOptions().position(MS).title("School of Music")
        )
        markerMS.tag = 0

        markerMSME = mMap.addMarker(
            MarkerOptions().position(MSME).title("Martin De Tours School of Managementand Economics")
        )
        markerMSME.tag = 0

        markerNS = mMap.addMarker(
            MarkerOptions().position(NS).title("Faculty of Nursing Science")
        )
        markerNS.tag = 0

        markerARTS = mMap.addMarker(
            MarkerOptions().position(ARTS).title("Theodore Maria School of Arts")
        )
        markerARTS.tag = 0

//        mMap.setOnMarkerClickListener(this)

        // Add a marker in Sydney and move the camera
        val currLoc = LatLng(13.612320, 100.836808)
        mMap.addMarker(MarkerOptions().position(currLoc ).title("User in ABAC Center"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currLoc ))
//
//        val vms = LatLng(13.613239, 100.835531)
//        mMap.addMarker(MarkerOptions().position(vms ).title("Vincent Mary School of Science and Technology"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(vms ))
    }

}