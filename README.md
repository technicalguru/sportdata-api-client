# sportdata-api-client
Java client for requesting data from [sportdataapi.com](https://sportdataapi.com).

## Synopsis
This Java client provides access to [sportdataapi.com](https://sportdataapi.com)'s REST API (soccer only). It returns data as
respective Java objects and encapsulates the REST API boilerplate of handling encoding/decoding JSON or correct
URL, HTTP headers and query parameter syntax. 

**Attention!** A valid subscription is required to use this client. Anonymous clients will not work.

## Status and Roadmap
The project is in Alpha phase. APIs are still subject to change.

* Beta version is expected to be available by November 15th, 2020.
* Release 1.0 is expected to be available by December 1st, 2020.

## Features
* Implementation of all soccer REST endpoints
* Handling of HTTP 404 return codes and returning empty lists or `null` values.
* Automatic decoding of values into corresponding Java objects wherever possible
* **Not** thread-safe. You will need a `SdaClient` per thread in case this is your requirement.

## Maven Coordinates

```
<dependency>
	<groupId>eu.ralph-schuster</groupId>
	<artifactId>sportdata-api-client</artifactId>
	<version>0.3</version>
</dependency>
```

## API Reference

Javadoc API for latest stable version is not yet available via a website. Working on it

## License

*sportdata-api-client* is free software: you can redistribute it and/or modify it under the terms of version 3 of the [GNU 
Lesser General Public License](LICENSE.md) as published by the Free Software Foundation.

*sportdata-api-client* is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public 
License for more details.

You should have received a copy of the GNU Lesser General Public License along with *sportdata-api-client*.  If not, see 
[https://www.gnu.org/licenses/lgpl-3.0.html](https://www.gnu.org/licenses/lgpl-3.0.html).

Summary:
 1. You are free to use all this code in any private or commercial project. 
 2. You must distribute license and author information along with your project.
 3. You are not required to publish your own source code.

## Usage Example
First, create your client instance via the `SdaClientFactory` using your API key:

```
	String    myApiKey = '00000000-0000-0000-0000-000000000000';
	SdaClient client   = SdaClientFactory.newClient(myApiKey);
```

Next is to retrieve the subclient for the API you wish to use and make your request, e.g.:

```
	LeaguesClient leaguesClient = client.soccer().leagues();
	List<League>  germanLeagues = leaguesClient.list(48);
```

Now, you could try to find the current season of each league:

```
	SeasonsClient seasonsClient = client.soccer.seasons();
	for (League league : germanLeagues) {
		List<Season> seasons = seasonsClient.list(league.getId());
		for (Season season : seasons) {
			if (season.isCurrent()) {
				...
			}
		}
	}
```

Once you are finished, you will need to close the client accordingly:

```
	client.close();
```

PS: It is a good pattern to always wrap the `get()` and `list()` calls in `try {} catch () {}` blocks
as the methods can still throw ``ForbiddenException`` or other exceptions that result from errors returned by the server.

## Developer Notes
Please be aware that JUnit tests require a valid API key from sportdataapi.com with the correct leagues subscribed to. Provide
the key either by setting environment variable `SDA_API_TOKEN` or creating a file `my-apikey.txt` that is available
in any of the classpath's folders, e.g. in `src/test/resources`. Be careful not to submit this file in any of your
code repositories.

## Contributions

Report a bug, request an enhancement or pull request at the [GitHub Issue Tracker](https://github.com/technicalguru/sportdata-api-client/issues). 
Make sure you have checked out the [Contribution Guideline](CONTRIBUTING.md)

 