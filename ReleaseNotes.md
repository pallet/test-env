## 0.1.5

- Add with-group-spec macro to cut test boilerplate
  The with-group-spec macro wraps a test that requires the specified 
  group-spec. Node creation is put in a `startup` block and node teardown in
  a `teardown` block.  Adds exception handling to ensure teardown occurs
  correctly.

- Add debug output to lein plugin

- Add :teardown-on-success
  Allow teardown of nodes only when a test succeeds.

- Add unique-name to generate unique names
  When naming groups in tests, using unique names allows tests to be run in
  parallel.

  Closes #5

- Add startup form and :no-startup profile
  The :no-startup profile can be used to control execution of any block 
  wrapped in the startup form.

- Use TEST_ENV_THREAD env var as thread count
  When set, the TEST_ENV_THREAD specifies the number of threads to use for 
  testing.  Defaults to 1.

  Closes #4

- pretty print test-results.edn
  Closes #3

## 0.1.4

- Add teardown form and :no-teardown profile
  When using the :no-teardown profile, any code wrapped in the teardown form
  is not executed.

## 0.1.3

- Update to pallet-aws 0.2.1

- Upgrade to lein-modules 0.2.2

- Workaround for add-profiles bug
  The bug is present in lein 2.3.4 and earlier.  The fix should be redundant
  on the next lein release.

## 0.1.2

- Remove the :parent in project.clj

- pallet-test-env depends on com.palletops/crates
  Uses the RELEASE version specification so latest image defintions are
  always picked up.

- Update default service names
  Uses :test-env-vmfest, :test-env-aws, and :test-env-jclouds

## 0.1.1

- Add lein-test-env
  A lein plugin to add scaffolding to a project using test-env.
  Use lein-modules to manage the two projects.

## 0.1.0

- Initial release
