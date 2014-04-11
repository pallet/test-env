# test-env

Provides a way for testing pallet crates against a defined set of
images, and reporting which features are supported on each image.

Uses [multi-test][multi-test] to run `clojure.test` tests multiple
times with different bindings for `*compute-service*` and
`*node-spec-meta*`.

Writes results to `test-results.edn`.

## Usage

In your `:dev` profile, add dependencies on:

```clj
[com.palletops/pallet-test-env "0.1.4"]
```

Add the plugin to your `:plugins`.  The plugin provides several
profiles for different providers.  You can list the profiles with
`lein test-env`.

```clj
[com.palletops/lein-test-env "0.1.4"]
```

The environment uses `project.clj` for configuration, so we need to
make this available with [configleaf][configleaf], which again is done
in the dev profile.

```clj
:plugins [[configleaf "0.4.6"]]
:configleaf {:config-source-path "test"
             :namespace pallet.crate.your-crate.project
             :verbose true}
```

Then add test selectors so we can run support tests on request only.

```clj
:test-selectors {:default (complement :support)
                 :support :support
                 :all (constantly true)}
```

Create a `support_test.clj` file, with a top-level `test-env` form.

```clj
(test-env pallet.crates.test-nodes/node-specs
          pallet.crate.your-crate.project/project)
```

Write tests annotated with `^:support`, which use `*compute-service*` and
`(:node-spec *node-spec-meta*)`.

## Configuration

Add profiles with pallet provider dependencies for the providers you
wish to test against. The `:aws`, `:vmfest` and `:jclouds` profiles
are provided by the plugin, using a `:service` of `:test-env-aws`,
`:test-env-vmfest` and `:test-env-jclouds` respectively.

In each of these profiles add a `:pallet/test-env` configuration map:

```
:pallet/test-env {:service :ec2
                  :test-specs
                  [{:selector :amzn-linux-2013-092
                    :expected [{:feature ["oracle-java-8"]
                                :expected? :not-supported}]}]}
```

Each feature that isn't supported should throw a :not-supported
exception, which can be declared as expected.


## Running Tests

```
lein with-profile +vmfest test :support
```

The `TEST_ENV_THREAD` environment variable can be used to set the
number of test threads (defaults to 1).


## Controlling Teardown of Nodes

The `teardown` form can be used to control the teardown of nodes in
tests.  Any code block wrapped in this form will not be run when the
`:no-teardown` profile is used.

## License

Copyright © 2014 Hugo Duncan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[configleaf]: https://github.com/davidsantiago/configleaf "configleaf"
[multi-test]: https://github.com/palletops/multi-test "multi-test"
