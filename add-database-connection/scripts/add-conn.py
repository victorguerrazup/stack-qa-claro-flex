from os import path
from templateframework.metadata import Metadata

def run(metadata: Metadata = None):
  target_path = metadata.target_path
  inputs = metadata.all_inputs()

  connectionSqlPath = path.join(target_path, 'base-module', 'src', 'main', 'kotlin', 'database', 'ConnectionSQL.kt')

  readFile = open(connectionSqlPath, "rt")
  fileData = readFile.read()
  readFile.close()

  if not inputs['database_name_camelcase'] + 'Connection()' in fileData:
    with open(connectionSqlPath, "wt") as writeFile:
      fileData = fileData.replace('companion object {', mount_connection_function(inputs))
      writeFile.write(fileData)

  return metadata


def mount_connection_function(inputs: dict):
  return ''.join(['companion object {\n',
  '       fun ' + inputs['database_name_camelcase'] + 'Connection() : Connection {\n',
  '          val ' + inputs['database_name_camelcase'] + 'Prefix = "' + inputs['database_properties_prefix'] + '"\n',
  '          val connection: Connection?\n',
  '          val host = envProperties.getProperty("${' + inputs['database_name_camelcase'] + 'Prefix}.host")\n',
  '          val port = envProperties.getProperty("${' + inputs['database_name_camelcase'] + 'Prefix}.port")\n',
  '          val database = envProperties.getProperty("${' + inputs['database_name_camelcase'] + 'Prefix}.name")\n',
  '          val user = envProperties.getProperty("${' + inputs['database_name_camelcase'] + 'Prefix}.user")\n',
  '          val password = envProperties.getProperty("${' + inputs['database_name_camelcase'] + 'Prefix}.password")\n',
  '          val url = "jdbc:' + inputs['database'] + '://${host}:${port}/${database}"\n',
  '          Class.forName("org.' + inputs['database'] + '.Driver")\n',
  '          connection = DriverManager.getConnection(url, user, password)\n',
  '          return connection\n',
  '      }'
  ])