# WFJava
# whistle_feed

Whistle_feed Ads plugin for Flutter Applications. This plugin is able to display Whistle_feed Ads.

## Getting Started

# Note

This plugin depends on other plugins like Provider , http , package_info and url_launcher .
*  Plugin uses provider package (while using this library if you already initialized provider then check it,if you are getting error on provider you can remove your provider or else fine)
   same for http,package_info url_launcher

This Dart package will utilize the plugin, **whistle_feed**, so to quickly and easily implement ads into a Flutter app.

# Sign Up and Get Your Publisher token here
[website link](https://publisher.whistle.mobi/)

Note:- Publisher token is required to serve the ads.


# initialize the plugin of latest version
And so, for this version, add this to your package's pubspec.yaml file instead:
yaml dependencies: whistle_feed: latest version

# Troubleshooting steps if ads are not showing.
1) Check if correct publisher token provided,
2) Passing addslistener as null or object of the class,
3) Minimum pencil size is 1
4) Maximum pencil size is 3

## for example
1 pencil = 1 cube , Maximum cube will be 3
Note :- required fields from developer : publisher token and pencil size (minimum size is 1 and maximum size is 4)

Androidmanifest.xml

## Step 1 :
# Place this permission tags inside manifest tags

               <uses-permission

               android:name="android.permission.INTERNET">

               </uses-permission>
 

# Place this tags in tags inside application tags

    android:usesCleartextTraffic="true
                 

## Step 3 :
 
          # Add the JitPack repository to your build file
 
         # Add it in your root build.gradle at the end of repositories:
 
                   allprojects {
		                   repositories {
		                                        	...
		                      maven { url 'https://jitpack.io' }
		                }
	                      }
                        
                        
 ## Step 4:
 
        # Add the dependency

         dependencies {     
	        implementation 'com.github.WhistleFeed:WFjava:1.0.0'
	        }

## Note: 
   # check latest Version By using this link

       [Java_sdk_link]https://jitpack.io/#WhistleFeed/WFjava
       
       
       
## Activity.xml 

         # Create an Xml file for the webview ui with id webview

                <com.whistle.whistlefeedjava.Whistlefeed
                    android:id="@+id/whistlefeed"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="16dp"
                    app:layout_constraintTop_toTopOf="parent">
                </com.whistle.whistlefeedjava.Whistlefeed>


                       
## Activity.java

          # Create a java file attach to 
          the xml UI 


          Whistlefeed whistlefeed = findViewById(R.id.whistlefeed);
          whistlefeed.setadds("21701655717485nYBzur_3267","3");


## OUTPUT
                 
## ONE ADD FORMAT
![1 cube adds](https://github.com/WhistleFeed/flutter_sdk/blob/master/screenshots/newadd1.png)

## TWO ADDS FORMAT
![2 cube adds](https://github.com/WhistleFeed/flutter_sdk/blob/master/screenshots/newadd2.png)

## THREE ADS FORMAT
![3 cube adds](https://github.com/WhistleFeed/flutter_sdk/blob/master/screenshots/newadd3.png)

## Github repository for reference

[github_repository](https://github.com/WhistleFeed/WFjava)
