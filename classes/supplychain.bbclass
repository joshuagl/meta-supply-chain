# This is a hack. In order to be able to run tuf in our SSTATEPOSTCREATEFUNCS
# and SSTATEPREINSTFUNCS we need it available to the host, adding a dependency
# to a task is the usual approach but for SSTATE*FUNCS the tasks we could hook
# into would introduce circular depdencies - how do we make sure the -native
# tool is available to the components it depends on? Thus, the cleanest way to
# ensure tuf is available it to depend on it as a HOSTTOOL.
# Yes tuf is really a Python library/module and as such there isn't a single
# binary we can test for the presence of in HOSTTOOL, furthermore an invocation
# like: "python3 -c 'import tuf'" doesn't work because the code to check the
# presence of HOSTTOOLS splits on spaces, perhaps we can make HOSTTOOLS accept
# arrays as members in future, i.e. HOSTTOOLS += "[python3 -c 'import tuf']"
# Until such time repo.py is a demo script currently installed by tuf
HOSTTOOLS += "repo.py"

# add the created sstate object to the tuf repo
python supplychain_postcreate () {
    bb.warn("sstate created - now...")
    init_repo()
    add_sstate_object()
}

# verify the object
python supplychain_preinst() {
    bb.warn("Installing sstate")
    verify_sstate_object()
}

SSTATEPOSTCREATEFUNCS_append = " supplychain_postcreate"
SSTATEPREINSTFUNCS_append = " supplychain_preinst"

# We need to ensure that tuf-native is present when sstate objects have
# been created
# DEPENDS += "tuf-native"

def init_repo():
    import msc.repo
    print("JLDBG:\tinit_repo")
    """
    Ensure the repo is configured
    TODO: when/where to call? 
        At "add sstate package" stage if repo doesn't exist?
    """
    pass

def add_sstate_object():
    import msc.repo
    print("JLDBG:\tadd_sstate_object")
    pass

def verify_sstate_object():
    import msc.client
    print("JLDBG:\tverify_sstate_object")
    pass
