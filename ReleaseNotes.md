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
