# Change Log

## v0.3

* Removed dependency to ehcache (not needed)
* Fixed timestamp parsing
* sportdataapi.com introduced fixes:
    * group reference is now part of match
    * live matches return empty list when no matches can be found in subscriptions
    * minAge restriction fixed
* Statistics for teams added

## v0.2

* Documentation added
* 404 Not Found responses create a NULL return object in getters now
* Github project name changed
* ID getter methods are consistent now