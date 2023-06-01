from templateframework.metadata import Metadata
from os import path

def run(metadata: Metadata = None):
  target_path = metadata.target_path
  component_path = metadata.component_path
  connectionSqlFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'database', 'ConnectionSQL.kt')
  snippetFile = path.join(component_path, 'snippets', 'ConnectionSQL.kt')

  if not path.exists(connectionSqlFile):
    with open(snippetFile, "rt") as snippet:
      with open(connectionSqlFile, "wt") as connectionSql:
        connectionSql.write(snippet.read())

  if metadata.inputs['database'] == 'postgresql':
    metadata.computed_inputs['database_package_group'] = 'org.postgresql'
    metadata.computed_inputs['database_package_id'] = 'postgresql'
    metadata.computed_inputs['database_package_version'] = '42.5.0'

  return metadata