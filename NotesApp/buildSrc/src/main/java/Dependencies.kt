/**
 * Created by Sanket Gurav on 2/21/2018.
 */
//https://handstandsam.com/2018/02/11/kotlin-buildsrc-for-better-gradle-dependency-management/
object Versions {
    val support_lib = "27.0.2"
    val retrofit = "2.3.0"
    val rxjava = "2.1.9"
}

object Dependencie {
    val support_annotations = "com.android.support:support-annotations:${Versions.support_lib}"
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
}