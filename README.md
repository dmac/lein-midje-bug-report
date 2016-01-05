This project is a test case for [marick/Midje#197](https://github.com/marick/Midje/issues/197).

To reproduce the exception, run `lein midje` in this project using the latest version of leiningen (2.5.3 at the time of this writing).

The exception is caused by an unquote in project.clj:

    :manifest {"Project-Name" ~#(:group %)}

Unquoting in project.clj is supported by leiningen, and can be seen in its sample [project.clj](https://github.com/technomancy/leiningen/blob/master/sample.project.clj)

The exception:

```
$ lein midje
Exception in thread "main" java.lang.RuntimeException: No reader function for tag object, compiling:(/private/var/folders/c3/ctpg5cqn37z90k0986yqnhgm0000gn/T/form-init8796919555141402049.clj:1:1418)
	at clojure.lang.Compiler.load(Compiler.java:7234)
	at clojure.lang.Compiler.loadFile(Compiler.java:7165)
	at clojure.main$load_script.invoke(main.clj:275)
	at clojure.main$init_opt.invoke(main.clj:280)
	at clojure.main$initialize.invoke(main.clj:308)
	at clojure.main$null_opt.invoke(main.clj:343)
	at clojure.main$main.doInvoke(main.clj:421)
	at clojure.lang.RestFn.invoke(RestFn.java:421)
	at clojure.lang.Var.invoke(Var.java:383)
	at clojure.lang.AFn.applyToHelper(AFn.java:156)
	at clojure.lang.Var.applyTo(Var.java:700)
	at clojure.main.main(main.java:37)
Caused by: java.lang.RuntimeException: No reader function for tag object
	at clojure.lang.LispReader$CtorReader.readTagged(LispReader.java:1245)
	at clojure.lang.LispReader$CtorReader.invoke(LispReader.java:1228)
	at clojure.lang.LispReader$DispatchReader.invoke(LispReader.java:684)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.readDelimitedList(LispReader.java:1200)
	at clojure.lang.LispReader$MapReader.invoke(LispReader.java:1158)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.readDelimitedList(LispReader.java:1200)
	at clojure.lang.LispReader$MapReader.invoke(LispReader.java:1158)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.readDelimitedList(LispReader.java:1200)
	at clojure.lang.LispReader$ListReader.invoke(LispReader.java:1049)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.readDelimitedList(LispReader.java:1200)
	at clojure.lang.LispReader$ListReader.invoke(LispReader.java:1049)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.readDelimitedList(LispReader.java:1200)
	at clojure.lang.LispReader$ListReader.invoke(LispReader.java:1049)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.readDelimitedList(LispReader.java:1200)
	at clojure.lang.LispReader$ListReader.invoke(LispReader.java:1049)
	at clojure.lang.LispReader.read(LispReader.java:263)
	at clojure.lang.LispReader.read(LispReader.java:196)
	at clojure.lang.Compiler.load(Compiler.java:7222)
	... 11 more
Subprocess failed
```
