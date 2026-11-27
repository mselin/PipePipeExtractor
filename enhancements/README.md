# The fork's own work on the extractor

> Working state, design doc and roadmap of the fork's work: [`docs/HANDOVER.md`](../docs/HANDOVER.md), which points to the client fork.

Branches, as in the client fork (`mselin/PipePipeClient`):

- `main` is an exact copy of upstream. It is only ever updated with "Sync fork".
- `enhancements/base` is `main` plus the fork's CI workflow and this file. After a sync it is
  rebased onto `main`.
- `enhancements/integration` is where the fork's changes are merged, through pull requests.
- Work branches (`fix/...`, `feature/...`) start from `enhancements/base`, and their pull
  requests go into `enhancements/integration`.

CI (`.github/workflows/extractor-ci.yml`, job `extractor-tests`) builds the extractor and runs
its unit tests on every push to these branches and on every pull request into them.
