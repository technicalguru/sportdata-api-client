# Change Log

## v0.9.3

* Issue #9 - Add group and stage information

## v0.9.2

* Bug #8 - Fix NULL values for RsDayDeserializer and RsDateDeserializer
* Issue #7 - New endpoint /soccer/referees

## v0.9.1

* Bug #4 - Fix match result parsing for canceled matches
* Bug #5 - Fix referee_id in matches
* Ignoring unknown JSON attributes in API responses
* Issue #6 - New match status TO_BE_ANNOUNCED

## v0.9

* Documentation

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