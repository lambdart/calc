
# Table of Contents

1.  [Introduction](#org519ade4)
2.  [Version](#orgebc567d)
3.  [Dependencies](#orga6d2c74)
4.  [Tested on](#orgb5509b8)
5.  [Installation](#org44a35ea)
6.  [Configuration](#org93c9ac0)
7.  [Testing](#orged2c95a)
8.  [LICENSE](#orga66c823)
9.  [EOF](#orgc1d9db4)



<a id="org519ade4"></a>

# Introduction

An simple full stack application.


<a id="orgebc567d"></a>

# Version

Alpha - 0.0.1


<a id="orga6d2c74"></a>

# Dependencies

All the dependencies are described on the `deps.edn` file, check it out :)


<a id="orgb5509b8"></a>

# Tested on

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-right" />
</colgroup>
<tbody>
<tr>
<td class="org-left">OS</td>
<td class="org-right">Version</td>
</tr>

<tr>
<td class="org-left">FreeBSD</td>
<td class="org-right">14.2</td>
</tr>

<tr>
<td class="org-left">Alpine</td>
<td class="org-right">3.23</td>
</tr>

<tr>
<td class="org-left">Docker</td>
<td class="org-right">28.2.2</td>
</tr>

<tr>
<td class="org-left">Chromium</td>
<td class="org-right">137.0.7151.55</td>
</tr>
</tbody>
</table>


<a id="org44a35ea"></a>

# Installation

The simplest way is to build the docker image and run the container, the
auto.sh scripts will help you on that, just

    
    ./scripts/auto.sh build
    ./scripts/auto.sh setup
    ./scripts/auto.sh start


<a id="org93c9ac0"></a>

# Configuration


<a id="orged2c95a"></a>

# Testing

It's possible to use curl or any http client of choice to access the API.
In case you are running this at your local host and the curl command is
installed, just type the following commands at the terminal emulator of use:

    
    curl "http://localhost:8080/v1/increment"
    curl "http://localhost:8080/v1/reset"


<a id="orga66c823"></a>

# LICENSE

MIT


<a id="orgc1d9db4"></a>

# EOF

