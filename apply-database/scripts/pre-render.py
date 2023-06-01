from templateframework.metadata import Metadata
from os import path
import json

def run(metadata: Metadata = None):
  target_path = metadata.target_path
  connectionSqlFile = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'database', 'ConnectionSQL.kt')

  metadata.computed_inputs['has_class'] = not path.exists(connectionSqlFile)

  if metadata.inputs['database'] == 'postgresql':
    metadata.computed_inputs['database_package_group'] = 'org.postgresql'
    metadata.computed_inputs['database_package_id'] = 'postgresql'
    metadata.computed_inputs['database_package_version'] = '42.5.0'

  return metadata