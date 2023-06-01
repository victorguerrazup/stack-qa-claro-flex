from os import path
from templateframework.metadata import Metadata

def run(metadata: Metadata = None):
  target_path = metadata.target_path
  inputs = metadata.all_inputs()

  buildGradlePath = path.join(target_path, 'base-module', 'build.gradle.kts')

  packageFullName = ':'.join(
    [inputs['database_package_group'],
    inputs['database_package_id'],
    inputs['database_package_version']]
  )

  readFile = open(buildGradlePath, "rt")
  fileData = readFile.read()
  readFile.close()

  if not packageFullName in fileData:
    with open(buildGradlePath, "wt") as writeFile:
      fileData = fileData.replace('dependencies {', 'dependencies {\n    implementation("' + packageFullName + '")')
      writeFile.write(fileData)

  return metadata