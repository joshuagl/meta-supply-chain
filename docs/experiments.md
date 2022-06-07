An OpenEmbedded/Yocto Project (OE/YP) layer for experimenting with existing
supply chain security solutions and their integration into the OE/YP build
system.


Initial work will be to determine whether we can integrate The Update Framework
(TUF) and in-toto into OE/YP in a meaningful way to increase the security of
using OE/YP to build custom Linux-based Operating Systems (OS) and associated
artefacts.


[TUF](https://theupdateframework.github.io/) is a specification and reference
implementation of mechanisms to build compromise resilient software
repositories.
OE/YP generates multiple artefacts of repositories during project usage:
- shared state objects (encapsulations of intermediate steps in the supply
  chain to accelerate future builds)
- packages and package feeds (OE/YP builds traditional Linux packages in a
  variety of formats as an intermediate step in constructing an OS, it's also
  capable of generating package feeds which can be used by the generated OS and
  images)
- various types of OS image

We plan to experiment initially with using TUF to secure shared state artefact
mirrors so that they can be more reliable shared as part of the supply chain.


[in-toto](https://in-toto.github.io/) is a specification and tool to define a
software supply chain - the steps in the supply chain and the actors who
perform those steps - and then use cryptographic techniques to verify that
every step of the supply chain was executed according to the definition.

Experimentation with in-toto will take two approaches:
1) A typical OE/YP project builds hundreds of software packages which utilise
a subset of a common series of steps - can we automatically generate the
software supply chain layout for all of these steps and still have it provide
any meaningful security properties?
2) can we define a high-level layout that encapsulates the non-automated steps
in a model OE/YP workflow and have that provide guarantees that cover the
automated parts of the workflow without having to specify an overly
large/complex supply chain layout?
By model, we mean that OE/YP are extremely versatile and non-proscriptive tools
- the model layout will define a best practice workflow for usage of the tools
to produce a custom Linux-based OS.
