# hbase-api-example

Download Source Code
<pre>
[user@host ~]$ git clone https://github.com/jackyoh/hbase-api-example.git
</pre>

Build Source Code
<pre>
[user@host ~]$ cd hbase-api-example/hbase-coprocessor-example
[user@host hbase-coprocessor-example]$ gradle clean build -x test
</pre>


Modify shell script
<pre>
[user@host hbase-coprocessor-example]$ cd shell
[user@host shell]$ vi registerOneTableCoprocessor.sh
</pre>

Run register coprocessor
<pre>
[user@host shell]$ bash registerOneTableCoprocessor.sh
</pre>
