This README file contains information on the contents of the meta-supply-chain layer.

Please see the corresponding sections below for details.

# Dependencies

  URI: https://git.openembedded.org/meta-openembedded/meta-oe
  branch: master

  URI: https://git.openembedded.org/meta-openembedded/meta-python
  branch: master

# Patches

Please submit any patches against the meta-supply-chain layer via a GitHub Pull
Request on the project's repository:
    https://github.com/joshuagl/meta-supply-chain

Maintainer: Joshua Lock <jlock@vmware.com> [@joshuagl](https://github.com/joshuagl)

# Table of Contents

  I. Adding the meta-supply-chain layer to your build
 II. Overview
III. Supply-chain Hardening
 IV. Future work


# I. Adding the meta-supply-chain layer to your build

Run 'bitbake-layers add-layer meta-supply-chain'

# II. Overview

meta-supply-chain is an OE layer to experiment with various tools and
techniques for securing the software supply chain.

## Prior art

Debian reproducible builds project have an in-toto apt transport that verifies
the packages installed have been cleanly rebuilt by one of the Debian
reproducible build rebuilders. This has the drawback that the in-toto apt
transport can't be used to verify all packages in the Debian archives,
because not all packages are yet reproducible.

We have a similar problem in OpenEmbedded in that not all packages are
reproducible, however we also have a different software supply chain and
developer workflow. Furthermore we can leverage fundamental features of the
OpenEmbedded build system, such as task hashes, to detect changes one might
rely on in-toto to detect in other systems.

# III. Supply-chain Hardening

## Defining the supply chain

OpenEmbedded/Yocto Project are extremeley versatile tools and are not utilised
in a consistent way so as to define a one-size fits all solution to securing
the software supply chain, and yet in an average deployment OpenEmbedded/Yocto
Project itself performs many/most of the steps in a typical supply-chain.

Therefore it is a prudent first step to use [in-toto](https://in-toto.io) to
protect the links in the OE/YP supply chain.

## Compromising the OE/YP Supply Chain

_TODO_: describe the attack to modify a binary in a package

# IV. Future Work

https://yoctoproject.org/docs/2.7/dev-manual/dev-manual.html#usingpoky-changes-collaborate

## Tools

* in-toto: verifies the correct steps in the supply chain were followed and
  verifies that tampering did not occur between steps
* TUF: 

## Threat model

* Pull various metadata layers from upstream locations
  - attack vector: compromised upstream
  - mitigation: [locked-sigs](https://wiki.yoctoproject.org/wiki/TipsAndTricks/LockSharedState)
    with in-toto signed modifications?
* Build proprietary components, OS and images from "private" layer
  - attack vector: revision control compromise
  - mitigation: signed commits
* Build "world" & run tests on CI/CD server
  - attack vector: compromise of CI/CD server
  - mitigation: in-toto signed builds
* Provide shared-state for developers
  - attack vector: compromise shared-state files
  - mitigation: TUF
* Provide package feeds for customers and image construction
  - attack vector: compromise package feeds
  - mitigation: signed feeds, signed packages, TUF, in-toto thresholds?
* Produce release binaries
  - attack vector:
  - mitigation: in-toto verification, in-toto inspection (do image contents match manifest?)

