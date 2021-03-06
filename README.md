# RoomDatabaseWithMvvm

![screenshot](https://user-images.githubusercontent.com/75353031/126887485-099f8140-fdad-46ec-bdd3-4c746e8153ad.png)


Used Dependency :

    dependencies {

    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.6.0'
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    def jetpack_version = "2.1.0"
    def room_version = "2.3.0"
    def arch_version = '2.2.0-alpha01'
    def retrofit_version = "2.6.1"
    def coroutines = "1.1.1"
    def kotlinCoroutineVersion = "1.1.1"
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'androidx.core:core-ktx:1.6.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'com.google.android.material:material:1.5.0-alpha01'

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion"

    //Room
    //implementation "androidx.room:room-runtime:$jetpack_version"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor "androidx.room:room-compiler:$room_version"
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    // To use Kotlin Symbolic Processing (KSP)
    //ksp("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // optional - RxJava2 support for Room
    implementation "androidx.room:room-rxjava2:$room_version"
    // optional - RxJava3 support for Room
    implementation "androidx.room:room-rxjava3:$room_version"
    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation "androidx.room:room-guava:$room_version"
    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    // Retrofit & OkHttp
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"
    testImplementation "com.android.support.test.espresso:espresso-core:3.0.2"
    testImplementation "androidx.test.ext:junit-ktx:1.1.3"
    androidTestImplementation "androidx.test.ext:junit-ktx:1.1.3"
    androidTestImplementation "org.mockito:mockito-core:3.5.13"
    testImplementation "org.mockito:mockito-core:3.5.13"
    testImplementation "android.arch.core:core-testing:2.1.0"
    testImplementation "com.squareup.okhttp3:mockwebserver:4.9.0"
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

   //androidTestImplementation 'com.android.support.test:runner:1.0.0'
    androidTestCompile "android.arch.core:core-testing:1.1.1"
    testImplementation 'org.robolectric:robolectric:4.4'

    //shimmer effect dependency
    implementation "com.facebook.shimmer:shimmer:0.5.0"

    //customized progress indicator
    implementation 'com.github.ybq:Android-SpinKit:1.4.0'

}
