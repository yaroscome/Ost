
## Description
Every viewable part of the app, represented by activity is grouped in a feature package. This approach keeps strong tied classes toghether for easier modification or removal when needed. For simplicity only RooSet Screen is made with MVP in mind.

Splash Screen downloads images and simlates persistance to local storage. Next Screen uses those images as background (where applicable) while dowloads all sets from API.

Clicking an item in the list should pick first available episode and get to the details. If episode has synopsis and images, they also will be displayed. Tap on **Home** set will open details to first episode.

Errors like 404, 500 or unknown error are handled by showing an alert.

## Running 
This example can be executed simply by loading project into Android Studio, syncing and running it.

